package org.example;

import java.util.ArrayDeque;
import java.util.Queue;

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

            for (int i = Math.min(reach, targetIndex - currentState.getIndex()); i >= 1 ; i--) {
                final int nextState = currentState.getIndex() + i;

                if (!visited[nextState]) {
                    nextStates.offer(State.create(nextState, currentState.getDistance() + 1));
                    visited[nextState] = true;
                }
            }
        }

        throw new IllegalArgumentException("Could not reach the end.");
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
