package com.meuprojeto.mapa.domain.valueobjects;

public class Coordinate{

	/**
	 * Ao usar final garantimos a imutabilidade.
	 */
	/**
	 * Uma otimização simples, pois coordenadas não mudam de lugar.
	 */

	private final double latitude;
	private final double longitude;

	public Coordinate(double latitude, double longitude) {
		/**
		 * Validação de Domínio. Impede que o sistema aceite coordenadas que não existem
		 * no planeta Terra.
		 */

		if (latitude < -90.0 || latitude > 90.0) {
			throw new IllegalArgumentException("Erro: Latitude deve estar entre -90 e 90. Valor recebido: " + latitude);
		}
		if (longitude < -180.0 || longitude > 180.0) {
			throw new IllegalArgumentException(
					"Erro: Longitude deve estar entre -180 e 180. Valor recebido: " + longitude);
		}

		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	/**
	 * Calcula a distância em linha reta (em metros) até outra coordenada. Utiliza a
	 * Fórmula de Haversine para considerar a curvatura da Terra.
	 */
	public double distanceTo(Coordinate other) {
		
		
		final int EARTH_RADIUS_METERS = 6371000; // Raio da Terra (média de 6,371 Km)

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