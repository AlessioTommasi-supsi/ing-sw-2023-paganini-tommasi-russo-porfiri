module org.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    //requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.rmi;
    requires com.google.gson;
    requires java.desktop;

    opens org.project to javafx.fxml;
    exports org.project.view.JavaFxUI;
    exports org.project.model;
    exports org.project.distributed;
    exports org.project.utils;
    exports org.project.controller;
    exports org.project;
}
