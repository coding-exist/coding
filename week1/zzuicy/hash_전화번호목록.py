def solution(phone_book):
    phone_nums = {}

    for phone_num in phone_book:
        phone_len = len(phone_num)
        phone_nums[phone_len] = phone_nums.get(phone_len) or set()
        phone_nums[phone_len].add(phone_num)

    for phone_num in phone_book:
        for length in phone_nums:
            if length >= len(phone_num):
                continue
            if phone_num[:length] in phone_nums.get(length):
                return False

    return True
