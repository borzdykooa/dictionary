package com.borzdykooa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dictionary implements Comparable<Dictionary> {

    private String word;
    private Long referenceId;

    @Override
    public int compareTo(Dictionary dictionary) {
        return word.compareTo(dictionary.getWord());
    }
}
