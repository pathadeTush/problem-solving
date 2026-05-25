public class HaversineDistance {

    private static final double EARTH_RADIUS_KM = 6371.0;

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        double deltaLat = lat2Rad - lat1Rad;
        double deltaLon = lon2Rad - lon1Rad;

        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                        Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS_KM * c;
    }

    public static double calculateDistance(double lon, double lat) {
        return calculateDistance(19.1018371, 72.8627593, lat, lon);
    }

    public static void main(String[] args) {
        System.out.println(calculateDistance(72.8627593, 19.1018371));
        System.out.println(calculateDistance(73.010709, 19.087303));
        System.out.println(calculateDistance(72.9794269, 19.1991202));
        System.out.println(calculateDistance(73.8504752, 18.5274658));
        System.out.println(calculateDistance(73.7600657, 20.0066628));
        System.out.println(calculateDistance(73.0346244, 20.3844204));
        System.out.println(calculateDistance(72.7933021, 21.1959098));
        System.out.println(calculateDistance(75.3252777, 19.8889012));
    }
}
