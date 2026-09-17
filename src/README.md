# MindMaze

## Adaptive Reasoning & Puzzle Assessment System

MindMaze is a Java-based CLI application that provides an interactive reasoning and puzzle assessment experience.

The system uses a rule-based adaptive engine to adjust the challenge level according to user performance. It also provides level unlocking, scoring, category-wise analysis, and assessment history.

## Features

- Multiple reasoning categories
- Three difficulty levels
- Rule-based adaptive difficulty
- Level unlocking based on performance
- Score and accuracy calculation
- Category-wise performance analysis
- Assessment history
- Input validation and error handling

## Categories

- Pattern Recognition
- Logical Reasoning
- Numerical Reasoning
- Mixed Challenge

## Difficulty Levels

- Level 1 – Beginner
- Level 2 – Intermediate
- Level 3 – Advanced

A minimum accuracy of 60% is required to unlock the next level.

## Technology Used

- Java
- JDK 26
- IntelliJ IDEA
- Git & GitHub
- File-based storage
- Command Line Interface (CLI)

## Project Structure

MindMaze/
├── src/
│   ├── model/
│   ├── service/
│   ├── util/
│   └── Main.java
├── data/
├── README.md
├── statement.md
└── .gitignore

## How to Run

1. Open the project in IntelliJ IDEA.
2. Configure JDK 26.
3. Open `src/Main.java`.
4. Run the `main()` method.
5. Follow the instructions displayed in the CLI.

## Testing

The application is tested for:

- Valid and invalid inputs
- Correct and incorrect answers
- Score calculation
- Accuracy calculation
- Level unlocking
- Adaptive difficulty
- Performance analysis
- Assessment history

## Future Enhancements

- Timed challenges
- Larger puzzle database
- More categories
- Leaderboard
- GUI version
- Database integration
- Detailed progress visualization