package recipes;

import lombok.Data;

@Data

public class IDWrapper {
    private int id;

    public IDWrapper(int id) {
        this.id = id;
    }
}