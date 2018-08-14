package com.qob.Pojo;

public enum Color {
    RED("红色", 1){
        @Override
        public long position2Time(int position) {
            return 1;
        }

        @Override
        public int time2Position(long time) {
            return 1;
        }

        @Override
        public int getCount() {
            return  100;
        }
    },
    GREEN("绿色", 2){
        @Override
        public long position2Time(int position) {
            return 2;
        }

        @Override
        public int time2Position(long time) {
            return 2;
        }
    },
    BLANK("黑色", 3){
        @Override
        public long position2Time(int position) {
            return 3;
        }

        @Override
        public int time2Position(long time) {
            return 3;
        }
    };
    private String name;
    private int index;

    private Color(String name, int index){
        this.name = name;
        this.index = index;
    }

    public abstract long position2Time(int position);

    /** @param time 即使不是某天的0点，也可以 */
    public abstract int time2Position(long time);

    public int getCount() {
        return  1;
    }

}
