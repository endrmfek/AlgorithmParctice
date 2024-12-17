def solution(nums):
    half = len(nums)/2
    return min(half, len(set(nums)))