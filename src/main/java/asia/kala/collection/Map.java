package asia.kala.collection;

import asia.kala.function.CheckedBiConsumer;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public interface Map<K, V> {

    V get(K key);

    void forEach(@NotNull BiConsumer<? super K, ? super V> consumer);

    default <Ex extends Throwable> void forEachChecked(
            @NotNull CheckedBiConsumer<? super K, ? super V, ? extends Ex> consumer
    ) throws Ex {
        forEach(consumer);
    }

    default void forEachUnchecked(@NotNull CheckedBiConsumer<? super K, ? super V, ?> consumer) {
        forEach(consumer);
    }
}
