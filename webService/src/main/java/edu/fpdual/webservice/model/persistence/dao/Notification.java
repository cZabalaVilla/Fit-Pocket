package edu.fpdual.webservice.model.persistence.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    private int id;
    private String title;
    private String body;

}
