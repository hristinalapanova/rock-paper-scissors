package com.ga;


    public abstract class Player {
        private String name;
        private boolean turn;
        private int points;

        public String getRecentMove() {
            return recentMove;
        }

        public void setRecentMove(String recentMove) {
            this.recentMove = recentMove;
        }

        private String recentMove;

        public Player (String name, boolean turn, int points, String recentMove){
            this.name=name;
            this.turn=turn;
            this.points=points;
            this.recentMove=recentMove;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isTurn() {
            return turn;
        }

        public void setTurn(boolean turn) {
            this.turn = turn;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }
}
