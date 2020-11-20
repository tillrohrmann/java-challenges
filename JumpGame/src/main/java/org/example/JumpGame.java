package org.example;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.function.IntFunction;

/**
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGame {
    public static int jump(int[] nums) {
        final int targetIndex = nums.length - 1;
        final boolean[] visited = new boolean[nums.length];

        final Queue<State> nextStates = new ArrayDeque<>();

        nextStates.offer(State.create(0, 0));

        State currentState;

        while ((currentState = nextStates.poll()) != null) {
            if (currentState.getIndex() == targetIndex) {
                return currentState.getDistance();
            }

            final int reach = nums[currentState.getIndex()];

            for (int i = Math.min(reach, targetIndex - currentState.getIndex()); i >= 1; i--) {
                final int nextState = currentState.getIndex() + i;

                if (!visited[nextState]) {
                    nextStates.offer(State.create(nextState, currentState.getDistance() + 1));
                    visited[nextState] = true;
                }
            }
        }

        throw new IllegalArgumentException("Could not reach the end.");
    }

    public static int jumpFast(int[] nums) {
        int steps = 0;
        int max = 0;
        int current = 0;
        int newMax = 0;

        while (true) {
            if (max >= nums.length - 1) {
                return steps;
            }
            steps++;

            while (current <= max) {

                if (current + nums[current] > newMax) {
                    newMax = current + nums[current];
                }

                current++;
            }

            max = newMax;
        }
    }

    public static final class State {
        private final int index;
        private final int distance;

        private State(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }

        public static State create(int index, int distance) {
            return new State(index, distance);
        }
    }
}
