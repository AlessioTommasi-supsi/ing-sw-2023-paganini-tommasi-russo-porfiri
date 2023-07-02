module org.project.ingsw2023PaganiniTommasiRussoPorfiri {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    requires com.almasb.fxgl.all;
    requires java.rmi;
    requires com.google.gson;
    requires java.desktop;

    opens org.project.ingsw2023PaganiniTommasiRussoPorfiri to javafx.fxml;
    opens org.project.ingsw2023PaganiniTommasiRussoPorfiri.model to com.google.gson;

    exports org.project.ingsw2023PaganiniTommasiRussoPorfiri;
    exports org.project.ingsw2023PaganiniTommasiRussoPorfiri.view;
    exports org.project.ingsw2023PaganiniTommasiRussoPorfiri.model;
    exports org.project.ingsw2023PaganiniTommasiRussoPorfiri.distributed;
    exports org.project.ingsw2023PaganiniTommasiRussoPorfiri.utils;
    exports org.project.ingsw2023PaganiniTommasiRussoPorfiri.controller;

}