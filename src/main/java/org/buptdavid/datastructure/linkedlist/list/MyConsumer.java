package org.buptdavid.datastructure.linkedlist.list;

import java.util.Objects;

public interface MyConsumer <T> {


    void accept(T t);


    default MyConsumer<T> andThen(MyConsumer<? super T> after)
    {
        Objects.requireNonNull(after);
        return (T t) ->{
            accept(t);
            after.accept(t);
        };
    }



}
