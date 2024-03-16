def solution(nums):
    unique_nums = list(set(nums))
    answer = min(len(nums) / 2, len(unique_nums))
    return answer
