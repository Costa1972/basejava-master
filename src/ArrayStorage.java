import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private static int size;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Optional<Resume> get(String uuid) {
        for (int i = 0; i <= size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return Optional.of(storage[i]);
            }
        }
        return Optional.empty();
    }

    void delete(String uuid) {
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return storage;
    }

    int size() {
        return 0;
    }
}
