package org.project.utils;

import org.project.model.*;


public interface Observer<SubjectType extends Observable, Event extends Choice> {


     void update(SubjectType o, Event arg);
}
