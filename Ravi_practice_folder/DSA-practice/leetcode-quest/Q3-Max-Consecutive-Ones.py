nums = [1,0,1,1,1,1,1,1,1,0,1,1,1,1,0,1]

count=0
ans=0
for i in range(0,len(nums)):
    if(nums[i]==0):
        if(ans<count):
            ans=count
        count=0
    else:
        count=count+1
    if(i==len(nums)-1):
        if(ans<count):
            ans=count

print(ans)