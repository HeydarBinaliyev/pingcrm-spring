<template>
  <app-layout>

    <template #header>
      <p>Main Page</p>
    </template>

     <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
            	 <b-form-input v-model="userNameFilter" placeholder="Enter name"></b-form-input>
            </div>
            <div class ="col-md-4">
                <b-button @click="getUsers()" variant="outline-primary">Search</b-button>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-12">
            	<b-table fixed hover size="xs" :items="users" :fields="fields" id="my-table">
                    <template v-slot:cell(actions)="row">
                        <b-button  variant="outline-info" class="mb-2"  @click="showDetails(row.item)">
                            <b-icon icon="pencil" aria-hidden="true"></b-icon>
                        </b-button>
                        <b-button variant="danger" class="mb-2"  @click="deleteUser(row.item)">
                            <b-icon icon="trash" aria-hidden="true"></b-icon>
                        </b-button>
                    </template>
                </b-table>
                
                
            </div>
        </div>

        <div class="row fixed">
          <div class="col-md-12">
          <b-pagination
                    v-model="currentPage"
                    :total-rows="count"
                    :per-page="perPage"
                    align="center"
                    @change="paginate"
                ></b-pagination></div>
        </div>

        <b-modal @show="modalOpen"
            id="userEditModal"
            title="User Info"
            :footer-bg-variant="'warning'"
            :header-bg-variant="'info'"
            size="lg"
        >
            <template v-slot:modal-footer>
                 <b-button size="sm" variant="success" ref="saveBtn" @click="save()">
                    Save
                </b-button>
                <b-button size="sm" variant="danger" @click="$bvModal.hide('userEditModal')">
                    Cancel
                </b-button>
            </template>
            <b-container fluid>
                <b-row class="mb-1"> 
                    <b-col cols="2" >
                        <!-- Element to gain focus when modal is opened -->
                        <label class="float-right">Username</label> 
                    </b-col>
                    <b-col cols="3">
                        <b-form-input  v-model="userData.name" ref="FIN_Input"></b-form-input>
                    </b-col>
                    <b-col cols="2">
                        <label class="float-right">email</label> 
                    </b-col>
                    <b-col cols="5">
                        <b-form-input  v-model="userData.email" ></b-form-input>
                    </b-col>
                </b-row>
                <b-row class="mb-1">
                    <b-col cols="2">
                        <label class="float-right">Roles</label> 
                    </b-col>
                    <b-col cols="10">
                       <vSelect v-model="userData.authorities"
                                label="name"
                                taggable
                                multiple
                                @search="getAuthorities"
                                :options="authoritiesList"
                       >
                       </vSelect>
                    </b-col>
                </b-row>
            </b-container>
        </b-modal>
    </div>

  </app-layout>
</template>

<script>
	
import AppLayout from "./Shared/AppLayout";
import Helper from './Helper.js';

export default{



  props:['users','count'],
  

  components:{
	  AppLayout
  },
	data(){
		return{
      
      	fields:[
    				{key:"name",sortable:true,label:'user name'},
                    {key:"email",sortable:true,label:'email'},
                    {key:"actions",label:'actions'},
                    
    			],
          userItems:[],
          perPage: 5,
          currentPage: 1,
          totalRows:0,
          userNameFilter:"",
          userData:{
              name:"",
              email:"",
              authorities:[]
          },
          modalType:false,
          authoritiesList:[],
          debouncedGetUsers:_.debounce(this.getUsers, 1000)

    }
  },
  
  mounted(){
            console.log('Component mounted.');
            let that = this;
            this.$root.$on('bv::modal::shown', (bvEvent, modalId) => {
                that.$refs.FIN_Input.focus();
                that.getAuthorities(null);
            });
            this.$root.$on('bv::modal::show', (bvEvent, modalId) => {
            });
  },
  created:function(){
      //to not requesting for each typed char.lodash bouncing property!!!look also for '_.throttle'
      //this.debouncedGetUsers = _.debounce(this.getUsers, 1000);
     // this.getUsers();
  },

  methods:{
          modalOpen(){
              // this.$refs.FIN_Input.focus();
          },
        	getUsers(pageNumber){
                let that = this;
                let page = pageNumber?pageNumber:that.currentPage;
                let offset = 5*(page - 1);
                let url = '/?name=' + this.userNameFilter + '&offset=' + offset;
                console.log(url);
               this.$inertia.replace(url, { only: ['users','count']})
          },
          showDetails(user){
                let that = this;
                Helper.createRequest("/getUser/" + user.name,"get",null,null,function(data){
                    console.log(data);
                    that.userData = data;
                    that.modalType = true;//means that modal action is must be 'post'
                    that.$bvModal.show("userEditModal");
                });
                console.log(this.messages);
          },
          save(){
                let method=this.modalType?"post":"put";
                let that = this;
                that.$refs.saveBtn.disabled=true;
                Helper.createRequest("/updateUser", method, that.userData, null, function(data){
                    console.log(data);
                    Helper.showMessage(data, that.messages, function(ok){
                        if(data.success){
                            that.$bvModal.hide("userEditModal");
                            that.getUsers();
                        }
                    });
                    that.$refs.saveBtn.disabled=false;
                });

          },
          deleteUser(user){
                let that = this;
                Helper.askConfirmation(that,true,"warning",function(ok){
                    console.log(ok);
                    if(ok){
                        Helper.createRequest("/deleteUser/" + user.id, "delete", null, null, function(data){
                            console.log(data);
                            Helper.showMessage(data, that.messages, function(){
                                if(data.success)
                                    that.getUsers();
                            });
                        });
                    }
                });
          },
          paginate(pageNumber){
                console.log(pageNumber);
                this.getUsers(pageNumber);
          },
          getAuthorities(search,loading){
                let params = {name:search};
                let that = this;
                loading = true;
                Helper.createRequest("/getAuthorities", "get", null, params, function(data){
                      console.log(data);
                      that.authoritiesList = data;
                      loading = false;
                });
          }
            
  },
  computed:{
        rows(){
                return 10;
          }
  },
  watch:{
      userNameFilter:function(val){
          this.debouncedGetUsers();
      }
  }




}
</script>
