<template>
  <div>
    <h1 class="header">상품 수정</h1>
    <el-form :model="form" :rules="rules" ref="form" label-width="120px" class="demo-ruleForm">
      <el-form-item label="상품명" prop="name">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <!-- 이미지 -->
      <el-form-item label="이미지" prop="image">
        <el-upload class="upload-demo" action="#" :on-preview="handlePreview"
          :on-remove="handleRemove" :auto-upload="false" list-type="picture" :file-list="fileList" :on-change="selectFile" :limit="1" :on-exceed="handleExceed">
          <el-button size="small" type="warning">Click to upload</el-button>
          <div slot="tip" class="el-upload__tip">jpg/png files with a size less than 500kb</div>
        </el-upload>
        <el-dialog v-model="dialogVisible">
          <img style="width:100%;" :src="dialogImageUrl" alt="" />
        </el-dialog>  
      </el-form-item>
      <!-- 상세 이미지 -->
      <el-form-item label="상세 정보 이미지" prop="detailImage">
        <el-upload class="upload-demo" action="#" :on-preview="handlePreviewDetail"
          :on-remove="handleRemove" :auto-upload="false" list-type="picture" :file-list="detailPicture" :on-change="selectdetailFile" :limit="1" :on-exceed="handleExceed">
          <el-button size="small" type="warning">Click to upload</el-button>
          <div slot="tip" class="el-upload__tip">jpg/png files with a size less than 500kb</div>
        </el-upload>
        <el-dialog v-model="dialogDetailVisible">
          <img style="width:100%;" :src="dialogDetailImageUrl" alt="" />
        </el-dialog>  
      </el-form-item>
      <!-- 가격 -->
      <el-form-item label="가격" prop="price">
        <el-input v-model.number="form.price"></el-input>
      </el-form-item>
      <!-- 카테고리 -->
      <el-form-item label="카테고리" prop="category">
        <el-select v-model="form.category" placeholder="카테고리를 선택해주세요.">
          <el-option label="사료" value="food"></el-option>
          <el-option label="산책" value="walking"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="옵션여부">
        <el-radio-group v-model="form.resource">
          <el-radio label="없음"></el-radio>
          <el-radio label="있음"></el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item v-if="form.resource=='있음'" label ="옵션">
        <el-input placeholder="옵션명" v-model="form.optionName" class="input-with-select">
          <!-- <el-button slot="append" icon="el-icon-plus"></el-button> -->
        </el-input>
        <el-tag :key="idx" v-for="(tag, idx) in dynamicTags" closable :disable-transitions="false" @close="handleClose(tag)" type="warning">
          {{tag}}
        </el-tag>
        <el-input class="input-new-tag" v-if="inputVisible" v-model="inputValue" ref="saveTagInput" 
          size="mini" @keyup.enter.native="handleInputConfirm" @blur="handleInputConfirm">
        </el-input>
        <el-button v-else class="button-new-tag" size="small" @click="showInput" type="warning">+ 옵션</el-button>
      </el-form-item>
      
      <el-form-item>
        <el-button type="warning" @click="onSubmit('form')">수정</el-button>
        <el-button @click="delItem()">삭제</el-button>
      </el-form-item>
    </el-form>
    
  </div>
</template>

<script>
import axios from 'axios';
export default {
    props : {
      id : String
    },
    beforeMount : function(){
      this.retrieveItem();
    },
    data() {
      return {
        form: {
          itCd : null,
          imgCd : null,
          name: '',
          price: '',
          category : '',
          resource: '없음',
          optionName : '',
          image : null,
          detailImage : null,
          optCd : null,
          itInfoCd : null
        },
        dialogImageUrl : '',
        dialogVisible : false,
        dialogDetailImageUrl : '',
        dialogDetailVisible : false,
        isOption : false,
        dynamicTags: [],
        inputVisible: false,
        inputValue: '',
        rules: {
          name: [
            { required: true, message: '상품명을 적어주세요', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '상품가격을 적어주세요', trigger: 'blur' },
            { type: 'number', message: '숫자를 입력해주세요'}
          ],
          category: [
            { required: true, message: '카테고리를 선택해주세요', trigger: 'change' }
          ]
        },
        fileList : [],
        detailPicture : [],
      }
    },
    methods: {
      onSubmit(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            if(this.form.resource == '없음'){
              this.isOption = false;
            }else{
              this.isOption = true;
            }
            let body = new FormData();
            body.append("name", this.form.name);
            body.append("price", this.form.price);
            body.append("isOption", this.isOption);
            body.append("category", this.form.category);
            body.append("optionName", this.form.optionName);
            body.append("option", this.dynamicTags);
            body.append("file", this.form.image);
            body.append("imgCd", this.form.imgCd);
            body.append("itCd", this.form.itCd);
            body.append("itInfoCd", this.form.itInfoCd);
            body.append("detailFile", this.form.detailImage);
            if(this.form.optCd != null){
              body.append("optCd", this.form.optCd);
            }
            const headers = {"Content-Type" : "multipart/form-data"};
            axios.put('http://localhost:8093/app/admin/itemUpdate', body, {headers : headers})
            .then(
              (res)=>{
                console.log(res);
              }
            )
            .catch(
              (error) =>{
                console.log(error);
              }
            );
              this.$router.push("/admin");
          } else {
            console.log('error submit!!');
            return false;
          }
        });
        
      },
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePreview(file) {
        this.dialogImageUrl = file.url;
        this.dialogVisible = true;
      },
      handlePreviewDetail(file){
        this.dialogDetailImageUrl = file.url;
        this.dialogDetailVisible = true;
      },
      handleExceed(){
        alert("2개 이상의 사진을 올릴 수 없습니다.");
      },
      handleClose(tag) {
        this.dynamicTags.splice(this.dynamicTags.indexOf(tag), 1);
      },
      showInput() {
        this.inputVisible = true;
        this.$nextTick(() => {
          this.$refs.saveTagInput.$refs.input.focus();
        });
      },
      selectFile(file){
        this.form.image = file.raw;
      },
      selectdetailFile(file){
        this.form.detailImage = file.raw;
      },
      handleInputConfirm() {
        let inputValue = this.inputValue;
        if (inputValue) {
          this.dynamicTags.push(inputValue);
        }
        this.inputVisible = false;
        this.inputValue = '';
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      retrieveItem : function(){
        axios.get("http://localhost:8093/app/item/itemRetrieve/" + this.id)
                .then(
                    (res)=> {
                        if(res.data.body !=null){
                          console.log("dd");
                          console.log(res.data.body);
                            this.data = res.data.body;
                            this.form.itCd = this.data.itemDTO.itCd;
                            this.form.name = this.data.itemDTO.itNm;
                            this.form.price = this.data.itemDTO.price;
                            this.form.category = this.data.itemDTO.cat;
                            this.form.imgCd = this.data.itemDTO.imgCd;
                            this.form.itInfoCd = this.data.itInfoCd;
                            if(this.data.itemDTO.optCd!=null){
                              this.form.resource = "있음";
                              this.form.optCd = this.data.itemDTO.optCd;
                              this.form.optionName = this.data.optionName;
                              this.data.optionCdList.map((data)=>{
                              this.dynamicTags.push(data.optNm);
                            })
                            }else{
                              this.form.resource = "없음"
                            }
                            var url = "http://localhost:8093/app/admin/view/" + this.data.itemDTO.imgCd;
                            this.fileList.push({ url : url});
                            this.form.image = null;
                            var detailUrl = "http://localhost:8093/app/api/file/detailView/" + this.data.itInfoCd;
                            this.detailPicture.push({url :detailUrl });
                            this.form.detailImage = null;
                    
                        }
                        
                    }
                )
                .catch(
                    (error) => {
                        console.log(error);
                    }
                )
        
      },
      delItem : function(){
        
        axios.delete("http://localhost:8093/app/admin/itemRetrieve/del" + this.id + "/" + this.form.imgCd)
          .then(
            (res)=>{
              console.log(res);
              
            }
          )
          .catch(
            (error)=>{
              console.log(error);
            }
          )
          // this.id=33;
      }
    }
  }
</script>

<style>
  .el-tag  {
    margin-right : 10px;
  }
  .button-new-tag {
    margin-left: 10px;
    height: 32px;
    line-height: 30px;
    padding-top: 0;
    padding-bottom: 0;
  }
  .input-new-tag {
    width: 90px;
    vertical-align: bottom;
  }
</style>