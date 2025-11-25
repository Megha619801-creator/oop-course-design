package controller;

import model.Pet;
import view.PetView;

public class PetController {
    private Pet pet;
    private PetView view;

    public PetController(Pet pet, PetView view) {
        this.pet = pet;
        this.view = view;
    }

    public void update() {
        pet.move();
        view.drawPet(pet.getX(), pet.getY());
    }

    public void setTarget(double x, double y) {
        pet.setTarget(x, y);
    }

    public void stopPet() {
        pet.stopMoving();
    }
}
