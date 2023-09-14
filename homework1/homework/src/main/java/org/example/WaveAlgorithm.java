package org.example;

import org.example.point.Point2D;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class WaveAlgorithm {
	int[][] map;

	public WaveAlgorithm(int[][] map) {
		this.map = map;
	}

	public void Colorize(Point2D startPoint) {
		Queue<Point2D> queue = new LinkedList<>();
		queue.add(startPoint);
		map[startPoint.x][startPoint.y] = 1;

		while (!queue.isEmpty()) {
			Point2D p = queue.remove();

			if (map[p.x - 1][p.y] == 0) {
				queue.add(new Point2D(p.x - 1, p.y));
				map[p.x - 1][p.y] = map[p.x][p.y] + 1;
			}
			if (map[p.x][p.y - 1] == 0) {
				queue.add(new Point2D(p.x, p.y - 1));
				map[p.x][p.y - 1] = map[p.x][p.y] + 1;
			}
			if (map[p.x + 1][p.y] == 0) {
				queue.add(new Point2D(p.x + 1, p.y));
				map[p.x + 1][p.y] = map[p.x][p.y] + 1;
			}
			if (map[p.x][p.y + 1] == 0) {
				queue.add(new Point2D(p.x, p.y + 1));
				map[p.x][p.y + 1] = map[p.x][p.y] + 1;
			}
		}
	}

	public ArrayList<Point2D> getRoad(Point2D exit) {
		ArrayList<Point2D> road = new ArrayList<>();
		road.add(exit);
		int temp = 99;
		int i = 0;
		while (temp != 1) {
			Point2D p = road.get(i++);
			if (map[p.x - 1][p.y] <= temp && map[p.x - 1][p.y] != -1) {
				temp = map[p.x - 1][p.y];
				map[p.x - 1][p.y] = 99;
				Point2D p1 = new Point2D(p.x, p.y);
				p1.x -= 1;
				road.add(p1);
				continue;
			}
			if (map[p.x][p.y - 1] < temp && map[p.x][p.y - 1] != -1) {
				temp = map[p.x][p.y - 1];
				map[p.x][p.y - 1] = 99;
				Point2D p1 = new Point2D(p.x, p.y);
				p1.y -= 1;
				road.add(p1);
				continue;
			}
			if (map[p.x + 1][p.y] < temp && map[p.x + 1][p.y] != -1) {
				temp = map[p.x + 1][p.y];
				map[p.x + 1][p.y] = 99;
				Point2D p1 = new Point2D(p.x, p.y);
				p1.x += 1;
				road.add(p1);
				continue;
			}
			if (map[p.x][p.y + 1] < temp && map[p.x][p.y + 1] != -1) {
				temp = map[p.x][p.y + 1];
				map[p.x][p.y + 1] = 99;
				Point2D p1 = new Point2D(p.x, p.y);
				p1.y += 1;
				road.add(p1);
			}
		}
		map[road.get(0).x][road.get(0).y] = -2;
		map[road.get(road.size() - 1).x][road.get(road.size() - 1).y] = -3;

		for (Point2D item : road) {
			System.out.println(item);
		}
		return road;
	}
}