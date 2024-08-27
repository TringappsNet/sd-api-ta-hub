package tahub.sdapitahub.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Board.Builder.class)
public class Board {
    private String id;
    private String column;

    private Board(Builder builder) {
        this.id = builder.id;
        this.column = builder.column;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {
        private String id;
        private String column;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder column(String columns) {
            this.column = columns;
            return this;
        }

        public Board build() {
            return new Board(this);
        }
    }
}
