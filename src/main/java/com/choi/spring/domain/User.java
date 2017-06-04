package com.choi.spring.domain;

import lombok.*;

import java.io.Serializable;

/**
 * Created by choi on 2017. 6. 2..
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String pw;
    private int login;
    private int recommend;
    private Level level;

    public void levelUp() {
        Level nextLevel = this.level.getNextLevel();
        if (nextLevel == null) {
            throw new IllegalStateException(this.level + "은 레벨업이 불가능합니다.");
        }
        this.level = nextLevel;
    }

    @Getter
    @AllArgsConstructor
    public enum Level {
        GOLD(3, null),
        SILVER(2, GOLD),
        BRONZE(1, SILVER);

        private final int value;
        private final Level nextLevel;

        public static Level valueOf(int value) {
            switch (value) {
                case 1: return BRONZE;
                case 2: return SILVER;
                case 3: return GOLD;
                default: throw new AssertionError("Unkown value : " + value);
            }
        }

    }
}
