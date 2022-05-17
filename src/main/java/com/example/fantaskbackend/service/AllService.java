package com.example.fantaskbackend.service;

import com.example.fantaskbackend.CrossSearchInput;
import com.example.fantaskbackend.CrossSearchItem;
import com.example.fantaskbackend.model.*;
import com.example.fantaskbackend.model.fkmodels.Authors;
import org.hibernate.search.engine.search.predicate.dsl.BooleanPredicateClausesStep;
import org.hibernate.search.mapper.orm.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AllService {

    @Autowired
    EntityManager entityManager;

    public List<CrossSearchItem> searchCrossAll(CrossSearchInput searchInput) {
        List<Object> objects = Search.session(entityManager)
                .search(Arrays.asList(Book.class, Comic.class, Film.class, Figure.class, Game.class))
                .where(f -> {
                            BooleanPredicateClausesStep<?> query = f.bool()
                                    .must(i -> i.match()
                                            .fields("authors.authorName", "bookSeries.bookSeriesName", "comicSeries.comicSeriesName", "comicSubseries.comicSubseriesName", "figureSeries.figureSeriesName", "filmSeries.filmSeriesName", "gameSeries.gameSeriesName", "gameSubseries.gameSubseriesName", "number", "title")
                                            .matching(searchInput.getFtsInput())
                                            .fuzzy()
                                    );

                            if (searchInput.isBox()) {
                                query.filter(box -> box.match()
                                        .field("box")
                                        .matching(true)
                                );
                            }

                            /*if (searchInput.getDate() != null) {
                                query.filter(date -> date.match()
                                        .field("date")
                                        .matching())
                            }

                             */

                            if (searchInput.isUnavailable()) {
                                query.filter(unavailable -> unavailable.match()
                                        .field("unavailable")
                                        .matching(false)
                                );
                            }

                            if (searchInput.isOutOfStock()) {
                                query.filter(outOfstock -> outOfstock.match()
                                        .field("outOfStock")
                                        .matching(false)
                                );
                            }

                            if (searchInput.isOnSale()) {
                                query.filter(onSale -> onSale.match()
                                        .field("onSale")
                                        .matching(true)
                                );
                            }

                            if (searchInput.isExcludeComing()) {
                                query.filter(c -> c.match()
                                        .field("coming")
                                        .matching(false)
                                );
                            }
                            if (searchInput.isShowComing()) {
                                query.filter(c -> c.match()
                                        .field("coming")
                                        .matching(true)
                                );
                            }

                            return query;
                        }
                )
                .fetchHits(50);

        List<CrossSearchItem> items = new ArrayList<>();

        for (Object object : objects) {
            if (object instanceof Book) {
                Book book = (Book) object;

                CrossSearchItem crossSearchItem = new CrossSearchItem(
                        book.getBookId(),
                        book.getAuthors().stream().map(Authors::getAuthorName).toList(),
                        book.getBookSeries() == null ? null : book.getBookSeries().getBookSeriesName(),
                        book.getTitle(),
                        null,
                        book.getNumber(),
                        "book"
                );
                items.add(crossSearchItem);

            } else if (object instanceof Comic) {
                Comic comic = (Comic) object;

                CrossSearchItem crossSearchItem = new CrossSearchItem(
                        comic.getComicId(),
                        comic.getAuthors().stream().map(Authors::getAuthorName).toList(),
                        comic.getComicSeries() == null ? null : comic.getComicSeries().getComicSeriesName(),
                        comic.getTitle(),
                        comic.getComicSubseries() == null ? null : comic.getComicSubseries().getComicSubseriesName(),
                        comic.getNumber(),
                        "comic"
                );
                items.add(crossSearchItem);

            } else if (object instanceof Game) {
                Game game = (Game) object;

                CrossSearchItem crossSearchItem = new CrossSearchItem(
                        game.getGameId(),
                        null,
                        game.getGameSeries() == null ? null : game.getGameSeries().getGameSeriesName(),
                        game.getTitle(),
                        game.getGameSubseries() == null ? null : game.getGameSubseries().getGameSubseriesName(),
                        null,
                        "game"
                );
                items.add(crossSearchItem);

            } else if (object instanceof Figure) {
                Figure figure = (Figure) object;

                CrossSearchItem crossSearchItem = new CrossSearchItem(
                        figure.getFigureId(),
                        null,
                        figure.getFigureSeries() == null ? null : figure.getFigureSeries().getFigureSeriesName(),
                        figure.getTitle(),
                        null,
                        null,
                        "figure"
                );
                items.add(crossSearchItem);

            } else if (object instanceof Film) {
                Film film = (Film) object;

                CrossSearchItem crossSearchItem = new CrossSearchItem(
                        film.getFilmId(),
                        null,
                        film.getFilmSeries() == null ? null : film.getFilmSeries().getFilmSeriesName(),
                        film.getTitle(),
                        null,
                        film.getNumber(),
                        "film"
                );
                items.add(crossSearchItem);

            }
        }

        return items;
    }
}
