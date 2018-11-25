package org.myspringframework.beans.factory.context;

/**
 * Интерфейс слушателя события
 */
public interface ApplicationListener<E> {

    /**
     * обработать событие
     * @param event событие
     */
    void onApplicationEvent(E event);

}
