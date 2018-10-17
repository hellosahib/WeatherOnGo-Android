package tech.rtsproduction.weather2go.Model;

public class WeatherInfo {
        private String iconLabel;
        private String tempHigh;
        private String tempLow;

        public WeatherInfo(String iconLabel, String tempHigh, String tempLow) {
            this.iconLabel = iconLabel;
            this.tempHigh = tempHigh;
            this.tempLow = tempLow;
        }

        public String getIconLabel() {
            return iconLabel;
        }

        public void setIconLabel(String iconLabel) {
            this.iconLabel = iconLabel;
        }

        public String getTempHigh() {
            return tempHigh;
        }

        public void setTempHigh(String tempHigh) {
            this.tempHigh = tempHigh;
        }

        public String getTempLow() {
            return tempLow;
        }

        public void setTempLow(String tempLow) {
            this.tempLow = tempLow;
        }
}
