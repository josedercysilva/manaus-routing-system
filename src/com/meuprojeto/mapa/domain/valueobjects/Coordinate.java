package com.meuprojeto.mapa.domain.valueobjects;

/**
 * Representa uma coordenada geográfica imutável (Latitude e Longitude).
 * Utilizada como base espacial para todos os elementos do mapa de Manaus.
 * 
 * @author José Dercy Vieira da Silva Filho
 * 
 * @version 1.0
 */
public class Coordinate {

	private final double latitude;
	private final double longitude;

	/**
	 * Cria uma nova coordenada geográfica com validação de limites globais.
	 * 
	 * @param latitude  Valor em graus decimais (entre -90.0 e 90.0).
	 * 
	 * @param longitude Valor em graus decimais (entre -180.0 e 180.0).
	 * @throws IllegalArgumentException Se as coordenadas estiverem fora dos limites
	 *                                  da Terra.
	 */
	public Coordinate(double latitude, double longitude) {
		if (latitude < -90.0 || latitude > 90.0) {
			throw new IllegalArgumentException("Latitude inválida: " + latitude);
		}
		if (longitude < -180.0 || longitude > 180.0) {
			throw new IllegalArgumentException("Longitude inválida: " + longitude);
		}

		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * Calcula a distância em linha reta entre esta coordenada e outra. Utiliza a
	 * fórmula de Haversine para compensar a curvatura da Terra, garantindo precisão
	 * essencial para o algoritmo de Dijkstra, por exemplo.
	 * 
	 * @param other A coordenada de destino.
	 * 
	 * @return A distância real em metros.
	 */
	public double distanceTo(Coordinate other) {

		final int EARTH_RADIUS_METERS = 6371000;
		double latDistance = Math.toRadians(other.latitude - this.latitude);
		double lonDistance = Math.toRadians(other.longitude - this.longitude);

		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(this.latitude))
				* Math.cos(Math.toRadians(other.latitude)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return EARTH_RADIUS_METERS * c;
	}

	@Override
	public String toString() {
		return "[" + latitude + ", " + longitude + "]";
	}
}