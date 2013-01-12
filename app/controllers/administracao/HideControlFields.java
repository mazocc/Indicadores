package controllers.administracao;

import controllers.CRUD;
import play.db.jpa.Model;

import java.util.List;

public class HideControlFields extends CRUD.ObjectType {

    public HideControlFields(Class<? extends Model> modelClass) {
        super(modelClass);
    }

    @Override
    public List<ObjectField> getFields() {
        List<ObjectField> result = super.getFields();
        for (ObjectField objectField : result) {
            if (objectField.name.equals("created_at") || objectField.name.equals("updated_at")) {
                objectField.type = "hidden";
            }
        }
        return result;
    }
}