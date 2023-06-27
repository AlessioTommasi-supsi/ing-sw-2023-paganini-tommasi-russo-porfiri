package org.project.ingsw2023PaganiniTommasiRussoPorfiri.utils;

import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.*;


public interface Observer<SubjectType extends Observable, Event extends Choice> {


     void update(SubjectType o, Event arg);
}
