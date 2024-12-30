package controller;

import model.PredmetModel;
import view.PredmetView;

    public class PredmetController {
        private PredmetModel model;
        private PredmetView view;

        public PredmetController(PredmetModel model, PredmetView view) {
            this.model = model;
            this.view = view;
        }

        public void updateNaziv(String naziv) {
            try {
                model.setNaziv(naziv);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        public void updateECTS(Double ECTS) {
            try {
                model.setECTS(ECTS);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


