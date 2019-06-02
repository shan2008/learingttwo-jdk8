package com.yous.learningtwo.host;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author syou
 * @date 2018/4/28.
 */
public class StreamUtils {
    private StreamUtils() {

    }

    /**
     * 将可能为空的List对象转换为它的stream,若为空则返回空列表的stream
     *
     * @param collection 待转换的列表
     * @param <T>  泛型
     * @return
     */
    public static <T> Stream<T> of(Collection<T> collection) {
        return Optional.ofNullable(collection)
                .map(Collection::stream)
                .orElseGet(Stream::empty);
    }

    /**
     * map ->list
     *
     * @param list
     * @param func
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> List<R> select(List<T> list, Function<T, R> func) {
        return Optional.ofNullable(list)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .map(func)
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * 条件过滤转List
     *
     * @param list
     * @param filter
     * @param <T>
     * @return
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> filter) {
        return Optional.ofNullable(list)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .filter(filter).collect(Collectors.toList());
    }


    /**
     * filter to select
     * @param list
     * @param filter
     * @param func
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> List<R> filterToSelect(List<T> list,  Predicate<T> filter,Function<T, R> func) {
        return Optional.ofNullable(list)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .filter(filter)
                .map(func)
                .distinct()
                .collect(Collectors.toList());
    }

}
