import itertools


def solution(participant, completion):
    participant.sort()
    completion.sort()

    for first, second in itertools.zip_longest(completion, participant):
        if first != second:
            return second
