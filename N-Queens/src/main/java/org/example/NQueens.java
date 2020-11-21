package org.example;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

public class NQueens {
    public static List<List<String>> solveNQueens(int n) {
        final List<List<String>> validSolutions = new ArrayList<>();
        final Stack<State> solutionCandidates = new Stack<>();
        solutionCandidates.push(new State(0, new BitSet(n * n), new int[n]));

        while (!solutionCandidates.isEmpty()) {
            final State solutionCandidate = solutionCandidates.pop();

            final Collection<State> nextSolutionCandidates = insertNextQueen(solutionCandidate, n);

            if (solutionCandidate.nextRow == n - 1) {
                for (State nextSolutionCandidate : nextSolutionCandidates) {
                    validSolutions.add(convertToSolution(nextSolutionCandidate, n));
                }
            } else {
                for (State nextSolutionCandidate : nextSolutionCandidates) {
                    solutionCandidates.push(nextSolutionCandidate);
                }
            }
        }

        return validSolutions;
    }

    private static Collection<State> insertNextQueen(State solutionCandidate, int n) {
        final Collection<State> nextSolutionCandidates = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!solutionCandidate.field.get(solutionCandidate.nextRow * n + i)) {
                nextSolutionCandidates.add(insertQueen(solutionCandidate, n, i));
            }
        }

        return nextSolutionCandidates;
    }

    private static State insertQueen(State solutionCandidate, int n, int column) {
        final BitSet newField = (BitSet) solutionCandidate.field.clone();
        final int[] newQueensPosition = solutionCandidate.queenPositions.clone();
        newQueensPosition[solutionCandidate.nextRow] = column;

        for (int i = solutionCandidate.nextRow + 1; i < n; i++) {
            // vertical
            newField.set(i * n + column);

            // diagonal left
            final int diff = i - solutionCandidate.nextRow;
            if (column - diff >= 0) {
                newField.set(i * n + column - diff);
            }

            // diagonal right
            if (column + diff < n) {
                newField.set(i * n + column + diff);
            }
        }

        return new State(solutionCandidate.nextRow + 1, newField, newQueensPosition);
    }

    private static List<String> convertToSolution(State solution, int n) {
        final List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            final StringBuilder builder = new StringBuilder();
            for (int j = 0; j < solution.queenPositions[i]; j++) {
                builder.append(".");
            }

            builder.append("Q");

            for (int j = solution.queenPositions[i] + 1; j < n; j++) {
                builder.append(".");
            }

            result.add(builder.toString());
        }

        return result;
    }

    public static final class State {
        final int nextRow;
        final BitSet field;
        final int[] queenPositions;

        public State(int nextRow, BitSet field, int[] queenPositions) {
            this.nextRow = nextRow;
            this.field = field;
            this.queenPositions = queenPositions;
        }
    }
}
