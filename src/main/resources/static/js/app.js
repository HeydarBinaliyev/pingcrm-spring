require('./bootstrap')
import { App, plugin } from '@inertiajs/inertia-vue'
import Vue from 'vue'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'

//Install BootstrapVue
Vue.use(BootstrapVue)
//Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin)
Vue.use(plugin)

const el = document.getElementById('app')


new Vue({
  render: h => h(App, {
    props: {
      initialPage: JSON.parse(el.dataset.page),
      resolveComponent: name => require(`./Pages/${name}`).default,
    },
  }),
}).$mount(el)

