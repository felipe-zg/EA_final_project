package com.example.ea_final_project.model;

import com.example.ea_final_project.model.utils.EntryGroup;
import com.example.ea_final_project.model.utils.Track;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Entry {
    @Id
    @GeneratedValue
    private Integer id;
    private Track track;
    private EntryGroup entryGroup;
}
