import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        List<Resume> resumeList = new ArrayList<>(Arrays.asList(storage));
        for (int i = 0; i < resumeList.size(); i++) {
            if (resumeList.get(i) != null) {
                if (resumeList.get(i).uuid.equals(uuid)) {
                    resumeList.remove(i);
                }
            }
        }
        storage = resumeList.toArray(Resume[]::new);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.stream(storage)
                .limit(size)
                .toArray(Resume[]::new);
    }

    int size() {
        return size;
    }
}
