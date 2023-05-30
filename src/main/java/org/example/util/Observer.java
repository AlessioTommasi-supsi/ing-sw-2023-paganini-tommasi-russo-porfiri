package org.example.util;

import org.example.model.*;


public interface Observer<SubjectType extends Observable, Event extends Choice> {


     void update(SubjectType o, Event arg);
}
