import xlwt
import json
import requests
from pyhanlp import *
import os
import PIL.Image
import glob
import datetime

#记录开始执行的时间
starttime=datetime.datetime.now()

#初始化Excel文件
softbei=xlwt.Workbook()
sheet=softbei.add_sheet('sheet')
sheet.col(1).width=8000
sheet.write(0,0,'图片')
sheet.write(0,1,'商铺名称')
#上传path文件夹路径内的所有图片，并按顺序排列
path=input()


#对照片进行压缩预处理
#并对照片的格式进行统一的转换
img_path = glob.glob(path + "/*.jpg")
path_save = ""
for file in img_path:
    name = os.path.join(path_save, file)
    im = PIL.Image.open(file)
    if im.mode != "RGB":
        im = im.convert('RGB')
    im.thumbnail((300,200))
    im.save(name,'JPEG')

fileList=os.listdir(path)
fileList.sort(key=lambda x:int(x[:-4]))
#遍历所有图片
line=0

for picture in fileList:
    line+=1
    #采用TrWebOCR实现图片文字识别，并返回json格式
    url='http://127.0.0.1:8089/api/tr-run/'
    img1_file={
        'file':open(path+'/'+picture,'rb')
        }
    res=requests.post(url=url,data={'compress':0},files=img1_file)
    #服务器不太稳定，通过code判断对response失败的picture进行跳过处理
    #if res.status_code <200 or res.status_code>299:
     #   sheet.write(line,0,picture)
     #   continue
    data=json.loads(res.text)
    if  data['code']!=200:
       sheet.write(line,0,picture)
       continue
    #处理json文件，由于网上没有TrWEB参数信息，经过测试初步认定raw_out内包含的信息为各个字段的横坐标（向右增加）、纵坐标（向下增加）、长度、高度、字段内容、查询时间
    ha_model = HanLP.newSegment().enableOrganizationRecognize(True)
    print(data['data']['raw_out'])
    list={}
    #获取所有字段内容并计算字段的面积（长*高）保存在list字典中
    for i in range(len(data['data']['raw_out'])):
        if len(data['data']['raw_out'][i][1])==0:
            continue
        list.update({data['data']['raw_out'][i][1]:data['data']['raw_out'][i][0][2]*data['data']['raw_out'][i][0][3]})
    #进行双优先级判断，通过pyhanlp自然语言处理进行命名体识别，初步找出疑似商铺名称的字段，选取面积最大的那个。如果没有符合的疑似商家名称字段，则直接选择面积最大的（商家会将商标做的最为明显从而吸引顾客）
    area=[0,0]
    match=["",""]
    for key in list:
        if list[key]>area[0]:
            area[0]=list[key]
            match[0]=key
        temp=ha_model.seg(key)
        print(temp)
        shop=str(temp[len(temp)-1].nature)
        shop1=str(temp[len(temp)-2].nature)
        if shop=='ni'or shop=='nis' or shop=='nic' or shop=='nit'or shop=='nt'or shop=='nrf'or shop[0:3]=='ntc'or(len(temp)>=2 and (('n'== shop[0] and shop!='nx') or shop=='vn' or shop1=='ns'or shop1=='nrf')):
            if list[key]>area[1]:
                area[1]=list[key]
                match[1]=key
    #将最切合的字段保存在Excel文件中
    sheet.write(line,0,picture)
    sheet.write(line,1,match[1] if area[1]!=0 else match[0])
    print(match[1] if area[1]!=0 else match[0])
#保存Excel文件，识别结束
softbei.save('softbei.xls')

#记录结束时间
endtime=datetime.datetime.now()
print(endtime-starttime)


