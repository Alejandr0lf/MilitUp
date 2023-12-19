package com.MilitUp;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;

public class simpleFactory implements EntityFactory {
    @Spawns("Enemy")
    public Entity newEnemy(SpawnData data) {
        return FXGL.entityBuilder(data).view("pietra.jpg").with(new ProjectileComponent(new Point2D(1, 0), 150))
                .build();
    }

    @Spawns("Ally")
    public Entity newAlly(SpawnData data) {
        return FXGL.entityBuilder(data).view(new Rectangle(50, 50)).with(new ProjectileComponent(new Point2D(-1, 0), 150))
                .build();
    }
}
