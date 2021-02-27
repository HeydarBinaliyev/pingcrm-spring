(window["webpackJsonp"] = window["webpackJsonp"] || []).push([[16],{

/***/ "./node_modules/babel-loader/lib/index.js?!./node_modules/vue-loader/lib/index.js?!./resources/js/Pages/Users/Index.vue?vue&type=script&lang=js&":
/*!*****************************************************************************************************************************************************************!*\
  !*** ./node_modules/babel-loader/lib??ref--4-0!./node_modules/vue-loader/lib??vue-loader-options!./resources/js/Pages/Users/Index.vue?vue&type=script&lang=js& ***!
  \*****************************************************************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _Shared_Icon__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @/Shared/Icon */ "./resources/js/Shared/Icon.vue");
/* harmony import */ var _Shared_Layout__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @/Shared/Layout */ "./resources/js/Shared/Layout.vue");
/* harmony import */ var lodash_mapValues__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! lodash/mapValues */ "./node_modules/lodash/mapValues.js");
/* harmony import */ var lodash_mapValues__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(lodash_mapValues__WEBPACK_IMPORTED_MODULE_2__);
/* harmony import */ var lodash_pickBy__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! lodash/pickBy */ "./node_modules/lodash/pickBy.js");
/* harmony import */ var lodash_pickBy__WEBPACK_IMPORTED_MODULE_3___default = /*#__PURE__*/__webpack_require__.n(lodash_pickBy__WEBPACK_IMPORTED_MODULE_3__);
/* harmony import */ var _Shared_SearchFilter__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @/Shared/SearchFilter */ "./resources/js/Shared/SearchFilter.vue");
/* harmony import */ var lodash_throttle__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! lodash/throttle */ "./node_modules/lodash/throttle.js");
/* harmony import */ var lodash_throttle__WEBPACK_IMPORTED_MODULE_5___default = /*#__PURE__*/__webpack_require__.n(lodash_throttle__WEBPACK_IMPORTED_MODULE_5__);
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//






/* harmony default export */ __webpack_exports__["default"] = ({
  metaInfo: {
    title: 'Users'
  },
  layout: _Shared_Layout__WEBPACK_IMPORTED_MODULE_1__["default"],
  components: {
    Icon: _Shared_Icon__WEBPACK_IMPORTED_MODULE_0__["default"],
    SearchFilter: _Shared_SearchFilter__WEBPACK_IMPORTED_MODULE_4__["default"]
  },
  props: {
    users: Array,
    filters: Object
  },
  data: function data() {
    return {
      form: {
        search: this.filters.search,
        role: this.filters.role,
        trashed: this.filters.trashed
      }
    };
  },
  watch: {
    form: {
      handler: lodash_throttle__WEBPACK_IMPORTED_MODULE_5___default()(function () {
        var query = lodash_pickBy__WEBPACK_IMPORTED_MODULE_3___default()(this.form); //this.$inertia.replace(this.route('users', Object.keys(query).length ? query : { remember: 'forget' }))
      }, 150),
      deep: true
    }
  },
  methods: {
    reset: function reset() {
      this.form = lodash_mapValues__WEBPACK_IMPORTED_MODULE_2___default()(this.form, function () {
        return null;
      });
    }
  }
});

/***/ }),

/***/ "./node_modules/vue-loader/lib/loaders/templateLoader.js?!./node_modules/vue-loader/lib/index.js?!./resources/js/Pages/Users/Index.vue?vue&type=template&id=5cc3d152&":
/*!*********************************************************************************************************************************************************************************************************!*\
  !*** ./node_modules/vue-loader/lib/loaders/templateLoader.js??vue-loader-options!./node_modules/vue-loader/lib??vue-loader-options!./resources/js/Pages/Users/Index.vue?vue&type=template&id=5cc3d152& ***!
  \*********************************************************************************************************************************************************************************************************/
/*! exports provided: render, staticRenderFns */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "render", function() { return render; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "staticRenderFns", function() { return staticRenderFns; });
var render = function() {
  var _vm = this
  var _h = _vm.$createElement
  var _c = _vm._self._c || _h
  return _c("div", [
    _c("h1", { staticClass: "mb-8 font-bold text-3xl" }, [_vm._v("Users")]),
    _vm._v(" "),
    _c(
      "div",
      { staticClass: "mb-6 flex justify-between items-center" },
      [
        _c(
          "search-filter",
          {
            staticClass: "w-full max-w-md mr-4",
            on: { reset: _vm.reset },
            model: {
              value: _vm.form.search,
              callback: function($$v) {
                _vm.$set(_vm.form, "search", $$v)
              },
              expression: "form.search"
            }
          },
          [
            _c("label", { staticClass: "block text-gray-700" }, [
              _vm._v("Role:")
            ]),
            _vm._v(" "),
            _c(
              "select",
              {
                directives: [
                  {
                    name: "model",
                    rawName: "v-model",
                    value: _vm.form.role,
                    expression: "form.role"
                  }
                ],
                staticClass: "mt-1 w-full form-select",
                on: {
                  change: function($event) {
                    var $$selectedVal = Array.prototype.filter
                      .call($event.target.options, function(o) {
                        return o.selected
                      })
                      .map(function(o) {
                        var val = "_value" in o ? o._value : o.value
                        return val
                      })
                    _vm.$set(
                      _vm.form,
                      "role",
                      $event.target.multiple ? $$selectedVal : $$selectedVal[0]
                    )
                  }
                }
              },
              [
                _c("option", { domProps: { value: null } }),
                _vm._v(" "),
                _c("option", { attrs: { value: "user" } }, [_vm._v("User")]),
                _vm._v(" "),
                _c("option", { attrs: { value: "owner" } }, [_vm._v("Owner")])
              ]
            ),
            _vm._v(" "),
            _c("label", { staticClass: "mt-4 block text-gray-700" }, [
              _vm._v("Trashed:")
            ]),
            _vm._v(" "),
            _c(
              "select",
              {
                directives: [
                  {
                    name: "model",
                    rawName: "v-model",
                    value: _vm.form.trashed,
                    expression: "form.trashed"
                  }
                ],
                staticClass: "mt-1 w-full form-select",
                on: {
                  change: function($event) {
                    var $$selectedVal = Array.prototype.filter
                      .call($event.target.options, function(o) {
                        return o.selected
                      })
                      .map(function(o) {
                        var val = "_value" in o ? o._value : o.value
                        return val
                      })
                    _vm.$set(
                      _vm.form,
                      "trashed",
                      $event.target.multiple ? $$selectedVal : $$selectedVal[0]
                    )
                  }
                }
              },
              [
                _c("option", { domProps: { value: null } }),
                _vm._v(" "),
                _c("option", { attrs: { value: "with" } }, [
                  _vm._v("With Trashed")
                ]),
                _vm._v(" "),
                _c("option", { attrs: { value: "only" } }, [
                  _vm._v("Only Trashed")
                ])
              ]
            )
          ]
        ),
        _vm._v(" "),
        _c(
          "inertia-link",
          { staticClass: "btn-indigo", attrs: { href: "/users/create" } },
          [
            _c("span", [_vm._v("Create")]),
            _vm._v(" "),
            _c("span", { staticClass: "hidden md:inline" }, [_vm._v("User")])
          ]
        )
      ],
      1
    ),
    _vm._v(" "),
    _c("div", { staticClass: "bg-white rounded shadow overflow-x-auto" }, [
      _c(
        "table",
        { staticClass: "w-full whitespace-no-wrap" },
        [
          _vm._m(0),
          _vm._v(" "),
          _vm._l(_vm.users, function(user) {
            return _c(
              "tr",
              {
                key: user.id,
                staticClass: "hover:bg-gray-100 focus-within:bg-gray-100"
              },
              [
                _c(
                  "td",
                  { staticClass: "border-t" },
                  [
                    _c(
                      "inertia-link",
                      {
                        staticClass:
                          "px-6 py-4 flex items-center focus:text-indigo-500",
                        attrs: { href: "/users/" + user.id + "/edit" }
                      },
                      [
                        user.photo
                          ? _c("img", {
                              staticClass:
                                "block w-5 h-5 rounded-full mr-2 -my-2",
                              attrs: { src: user.photo }
                            })
                          : _vm._e(),
                        _vm._v(
                          "\n            " +
                            _vm._s(user.name) +
                            "\n            "
                        ),
                        user.deleted_at
                          ? _c("icon", {
                              staticClass:
                                "flex-shrink-0 w-3 h-3 fill-gray-400 ml-2",
                              attrs: { name: "trash" }
                            })
                          : _vm._e()
                      ],
                      1
                    )
                  ],
                  1
                ),
                _vm._v(" "),
                _c(
                  "td",
                  { staticClass: "border-t" },
                  [
                    _c(
                      "inertia-link",
                      {
                        staticClass: "px-6 py-4 flex items-center",
                        attrs: {
                          href: "/users/" + user.id + "/edit",
                          tabindex: "-1"
                        }
                      },
                      [
                        _vm._v(
                          "\n            " + _vm._s(user.email) + "\n          "
                        )
                      ]
                    )
                  ],
                  1
                ),
                _vm._v(" "),
                _c(
                  "td",
                  { staticClass: "border-t" },
                  [
                    _c(
                      "inertia-link",
                      {
                        staticClass: "px-6 py-4 flex items-center",
                        attrs: {
                          href: "/users/" + user.id + "/edit",
                          tabindex: "-1"
                        }
                      },
                      [
                        _vm._v(
                          "\n            " +
                            _vm._s(user.owner ? "Owner" : "User") +
                            "\n          "
                        )
                      ]
                    )
                  ],
                  1
                ),
                _vm._v(" "),
                _c(
                  "td",
                  { staticClass: "border-t w-px" },
                  [
                    _c(
                      "inertia-link",
                      {
                        staticClass: "px-4 flex items-center",
                        attrs: {
                          href: "/users/" + user.id + "/edit",
                          tabindex: "-1"
                        }
                      },
                      [
                        _c("icon", {
                          staticClass: "block w-6 h-6 fill-gray-400",
                          attrs: { name: "cheveron-right" }
                        })
                      ],
                      1
                    )
                  ],
                  1
                )
              ]
            )
          }),
          _vm._v(" "),
          _vm.users.length === 0
            ? _c("tr", [
                _c(
                  "td",
                  {
                    staticClass: "border-t px-6 py-4",
                    attrs: { colspan: "4" }
                  },
                  [_vm._v("No users found.")]
                )
              ])
            : _vm._e()
        ],
        2
      )
    ])
  ])
}
var staticRenderFns = [
  function() {
    var _vm = this
    var _h = _vm.$createElement
    var _c = _vm._self._c || _h
    return _c("tr", { staticClass: "text-left font-bold" }, [
      _c("th", { staticClass: "px-6 pt-6 pb-4" }, [_vm._v("Name")]),
      _vm._v(" "),
      _c("th", { staticClass: "px-6 pt-6 pb-4" }, [_vm._v("Email")]),
      _vm._v(" "),
      _c("th", { staticClass: "px-6 pt-6 pb-4", attrs: { colspan: "2" } }, [
        _vm._v("Role")
      ])
    ])
  }
]
render._withStripped = true



/***/ }),

/***/ "./resources/js/Pages/Users/Index.vue":
/*!********************************************!*\
  !*** ./resources/js/Pages/Users/Index.vue ***!
  \********************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _Index_vue_vue_type_template_id_5cc3d152___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./Index.vue?vue&type=template&id=5cc3d152& */ "./resources/js/Pages/Users/Index.vue?vue&type=template&id=5cc3d152&");
/* harmony import */ var _Index_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./Index.vue?vue&type=script&lang=js& */ "./resources/js/Pages/Users/Index.vue?vue&type=script&lang=js&");
/* empty/unused harmony star reexport *//* harmony import */ var _node_modules_vue_loader_lib_runtime_componentNormalizer_js__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../../node_modules/vue-loader/lib/runtime/componentNormalizer.js */ "./node_modules/vue-loader/lib/runtime/componentNormalizer.js");





/* normalize component */

var component = Object(_node_modules_vue_loader_lib_runtime_componentNormalizer_js__WEBPACK_IMPORTED_MODULE_2__["default"])(
  _Index_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_1__["default"],
  _Index_vue_vue_type_template_id_5cc3d152___WEBPACK_IMPORTED_MODULE_0__["render"],
  _Index_vue_vue_type_template_id_5cc3d152___WEBPACK_IMPORTED_MODULE_0__["staticRenderFns"],
  false,
  null,
  null,
  null
  
)

/* hot reload */
if (false) { var api; }
component.options.__file = "resources/js/Pages/Users/Index.vue"
/* harmony default export */ __webpack_exports__["default"] = (component.exports);

/***/ }),

/***/ "./resources/js/Pages/Users/Index.vue?vue&type=script&lang=js&":
/*!*********************************************************************!*\
  !*** ./resources/js/Pages/Users/Index.vue?vue&type=script&lang=js& ***!
  \*********************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _node_modules_babel_loader_lib_index_js_ref_4_0_node_modules_vue_loader_lib_index_js_vue_loader_options_Index_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! -!../../../../node_modules/babel-loader/lib??ref--4-0!../../../../node_modules/vue-loader/lib??vue-loader-options!./Index.vue?vue&type=script&lang=js& */ "./node_modules/babel-loader/lib/index.js?!./node_modules/vue-loader/lib/index.js?!./resources/js/Pages/Users/Index.vue?vue&type=script&lang=js&");
/* empty/unused harmony star reexport */ /* harmony default export */ __webpack_exports__["default"] = (_node_modules_babel_loader_lib_index_js_ref_4_0_node_modules_vue_loader_lib_index_js_vue_loader_options_Index_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0__["default"]); 

/***/ }),

/***/ "./resources/js/Pages/Users/Index.vue?vue&type=template&id=5cc3d152&":
/*!***************************************************************************!*\
  !*** ./resources/js/Pages/Users/Index.vue?vue&type=template&id=5cc3d152& ***!
  \***************************************************************************/
/*! exports provided: render, staticRenderFns */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _node_modules_vue_loader_lib_loaders_templateLoader_js_vue_loader_options_node_modules_vue_loader_lib_index_js_vue_loader_options_Index_vue_vue_type_template_id_5cc3d152___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! -!../../../../node_modules/vue-loader/lib/loaders/templateLoader.js??vue-loader-options!../../../../node_modules/vue-loader/lib??vue-loader-options!./Index.vue?vue&type=template&id=5cc3d152& */ "./node_modules/vue-loader/lib/loaders/templateLoader.js?!./node_modules/vue-loader/lib/index.js?!./resources/js/Pages/Users/Index.vue?vue&type=template&id=5cc3d152&");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "render", function() { return _node_modules_vue_loader_lib_loaders_templateLoader_js_vue_loader_options_node_modules_vue_loader_lib_index_js_vue_loader_options_Index_vue_vue_type_template_id_5cc3d152___WEBPACK_IMPORTED_MODULE_0__["render"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "staticRenderFns", function() { return _node_modules_vue_loader_lib_loaders_templateLoader_js_vue_loader_options_node_modules_vue_loader_lib_index_js_vue_loader_options_Index_vue_vue_type_template_id_5cc3d152___WEBPACK_IMPORTED_MODULE_0__["staticRenderFns"]; });



/***/ })

}]);