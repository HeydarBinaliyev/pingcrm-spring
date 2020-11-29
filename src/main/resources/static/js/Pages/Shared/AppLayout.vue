<template>
<div>
  <b-navbar toggleable="lg" type="dark" variant="info">

    <b-navbar-brand href="#">NavBar</b-navbar-brand>

    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav>
        <b-nav-item href="#">Link</b-nav-item>
        <b-nav-item @click="goto('/profil')" >Admin</b-nav-item>
      </b-navbar-nav>

      <!-- Right aligned nav items -->
      <b-navbar-nav class="ml-auto">
        <b-nav-form>
          <b-form-input size="sm" class="mr-sm-2" placeholder="Search"></b-form-input>
          <b-button size="sm" class="my-2 my-sm-0" type="submit">Search</b-button>
        </b-nav-form>


        <b-nav-item-dropdown text="Lang" right>
          <b-dropdown-item href="#">EN</b-dropdown-item>
          <b-dropdown-item href="#">ES</b-dropdown-item>
          <b-dropdown-item href="#">RU</b-dropdown-item>
        </b-nav-item-dropdown>

        <b-nav-item-dropdown right >
          <!-- Using 'button-content' slot -->
          <template #button-content>
            <em>{{$page.props.name}}</em>
          </template>
          <b-dropdown-item href="#">Profile</b-dropdown-item>
          <b-dropdown-item href="#">Sign Out</b-dropdown-item>
        </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-collapse>

  </b-navbar>

  <header>
    <div class="layout-header">
      <slot name="header"></slot>
    </div>
  </header>

  <main style="padding: 0.5rem 1rem;" class="py-4">

        <slot></slot>

  </main>

  <div class="layout-footer">
      <p>Heydar Binaliyev@2020</p>
  </div>

</div>
</template>

<script>
export default {

  name:"AppLayout",

  methods:{
    goto(url){
      this.$inertia.get(url);
    }
  }

}
</script>

<style scoped>

.layout-header{

    margin-top: 2px;
    padding: 0.5rem 1rem;
    box-sizing: border-box;
    align-items: center;

}
.layout-main{
  margin-top: 5px;
  padding: 0.5rem 1rem;
  box-sizing: border-box;
  align-items: center;

}
.layout-footer{
  position: fixed;
  left: 0;
  bottom: 0;
  width: 100%;
  background-color:#17a2b8;
  color: white;
  text-align: center;
}

</style>
