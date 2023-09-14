package org.example.map;

import org.example.cahrs.chars;

public class MapPrinter {

	public MapPrinter() {
	}

	public String rawData(int[][] map) {
		StringBuilder sb = new StringBuilder();

		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[row].length; col++) {
				sb.append(String.format("%5d", map[row][col]));
			}
			sb.append("\n");
		}
		for (int i = 0; i < 3; i++) {
			sb.append("\n");
		}

		return sb.toString();
	}

	public String mapColor(int[][] map) {
		StringBuilder sb = new StringBuilder();

		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[row].length; col++) {
				switch (map[row][col]) {
					case 0:
						sb.append(chars.getStena2() + " ");
						break;
					case -1:
						sb.append(chars.getStena1() + " ");
						break;
					case -2:
					case -3:
					case 1: // cat and exit
						sb.append(chars.getChar3() + " ");
						break;
					case 99: // road
						sb.append(chars.getRoad() + " ");
						break;
					default: // none
						sb.append(chars.getStena2() + " ");
						break;
				}
			}
			sb.append("\n");
		}
		for (int i = 0; i < 3; i++) {
			sb.append("\n");
		}
		return sb.toString();
	}
}