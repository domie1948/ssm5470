<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
    >  
     <el-row>
                              <el-col :span="12">
        <el-form-item  v-if="flag=='laoshi'"  label="老师工号" prop="laoshigonghao">
          <el-input v-model="ruleForm.laoshigonghao" 
              placeholder="老师工号" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="flag=='laoshi'"  label="密码" prop="mima">
          <el-input v-model="ruleForm.mima" 
              placeholder="密码" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="flag=='laoshi'"  label="老师姓名" prop="laoshixingming">
          <el-input v-model="ruleForm.laoshixingming" 
              placeholder="老师姓名" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="flag=='laoshi'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie" placeholder="请选择性别">
            <el-option
                v-for="(item,index) in laoshixingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
                        <el-col :span="24">  
        <el-form-item v-if="flag=='laoshi'" label="照片" prop="zhaopian">
          <file-upload
          tip="点击上传照片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.zhaopian?ruleForm.zhaopian:''"
          @change="laoshizhaopianUploadChange"
          ></file-upload>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="flag=='laoshi'"  label="班级" prop="banji">
          <el-select v-model="ruleForm.banji" placeholder="请选择班级">
            <el-option
                v-for="(item,index) in laoshibanjiOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="flag=='laoshi'"  label="老师邮箱" prop="laoshiyouxiang">
          <el-input v-model="ruleForm.laoshiyouxiang" 
              placeholder="老师邮箱" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="flag=='laoshi'"  label="手机" prop="shouji">
          <el-input v-model="ruleForm.shouji" 
              placeholder="手机" clearable></el-input>
        </el-form-item>
      </el-col>
                                                <el-col :span="12">
        <el-form-item  v-if="flag=='jiazhang'"  label="家长账号" prop="jiazhangzhanghao">
          <el-input v-model="ruleForm.jiazhangzhanghao" 
              placeholder="家长账号" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="flag=='jiazhang'"  label="密码" prop="mima">
          <el-input v-model="ruleForm.mima" 
              placeholder="密码" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="flag=='jiazhang'"  label="家长姓名" prop="jiazhangxingming">
          <el-input v-model="ruleForm.jiazhangxingming" 
              placeholder="家长姓名" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="flag=='jiazhang'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie" placeholder="请选择性别">
            <el-option
                v-for="(item,index) in jiazhangxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
                        <el-col :span="24">  
        <el-form-item v-if="flag=='jiazhang'" label="头像" prop="touxiang">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
          @change="jiazhangtouxiangUploadChange"
          ></file-upload>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="flag=='jiazhang'"  label="学生姓名" prop="xueshengxingming">
          <el-input v-model="ruleForm.xueshengxingming" 
              placeholder="学生姓名" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="flag=='jiazhang'"  label="班级" prop="banji">
          <el-select v-model="ruleForm.banji" placeholder="请选择班级">
            <el-option
                v-for="(item,index) in jiazhangbanjiOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="flag=='jiazhang'"  label="年龄" prop="nianling">
          <el-input v-model="ruleForm.nianling" 
              placeholder="年龄" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="flag=='jiazhang'"  label="关系" prop="guanxi">
          <el-select v-model="ruleForm.guanxi" placeholder="请选择关系">
            <el-option
                v-for="(item,index) in jiazhangguanxiOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="flag=='jiazhang'"  label="联系电话" prop="lianxidianhua">
          <el-input v-model="ruleForm.lianxidianhua" 
              placeholder="联系电话" clearable></el-input>
        </el-form-item>
      </el-col>
                                                                                                                                                                              <el-form-item v-if="flag=='users'" label="用户名" prop="username">
        <el-input v-model="ruleForm.username" 
        placeholder="用户名"></el-input>
      </el-form-item>
      <el-col :span="24">
      <el-form-item>
        <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
      </el-form-item>
      </el-col>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
                                                                  laoshixingbieOptions: [],
                                    laoshibanjiOptions: [],
                                                                                                            jiazhangxingbieOptions: [],
                                                jiazhangbanjiOptions: [],
                                    jiazhangguanxiOptions: [],
                                                                                                                                                                                        };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
                                            this.laoshixingbieOptions = "男,女".split(',')
                        this.$http({
      url: `option/banji/banji`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.laoshibanjiOptions = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
                                                                        this.jiazhangxingbieOptions = "男,女".split(',')
                                this.$http({
      url: `option/banji/banji`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.jiazhangbanjiOptions = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
                        this.jiazhangguanxiOptions = "父女,父子,母女,母子,其他".split(',')
                                                                                                                          },
  methods: {
                                                                                                                                                                                                                                                                                                                                        laoshizhaopianUploadChange(fileUrls) {
        this.ruleForm.zhaopian = fileUrls;
    },
                                                                                        jiazhangtouxiangUploadChange(fileUrls) {
        this.ruleForm.touxiang = fileUrls;
    },
                                                                                                                                                            onUpdateHandler() {
                              if((!this.ruleForm.laoshigonghao)&& 'laoshi'==this.flag){
        this.$message.error('老师工号不能为空');
        return
      }
                                                            if((!this.ruleForm.mima)&& 'laoshi'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
                                                                                                                                                                                                                                                                                    if( 'laoshi' ==this.flag && this.ruleForm.laoshiyouxiang&&(!isEmail(this.ruleForm.laoshiyouxiang))){
        this.$message.error(`老师邮箱应输入邮箱格式`);
        return
      }
                                                                                                            if((!this.ruleForm.jiazhangzhanghao)&& 'jiazhang'==this.flag){
        this.$message.error('家长账号不能为空');
        return
      }
                                                            if((!this.ruleForm.mima)&& 'jiazhang'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
                                                                                                                                                                                                                                                                                                                  if( 'jiazhang' ==this.flag && this.ruleForm.nianling&&(!isIntNumer(this.ruleForm.nianling))){
       this.$message.error(`年龄应输入整数`);
        return
      }
                                                                                                                                                                                                                                                                                                            this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
