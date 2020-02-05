package com.yous.learningtwo.host.productJson;

import java.util.List;

/**
 * @author syou
 * @date 2019/9/24.
 */
public class CommonTagDTO {
    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    private double score;
    private List<String> tags;


}
