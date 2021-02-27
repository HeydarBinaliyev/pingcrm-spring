(window["webpackJsonp"] = window["webpackJsonp"] || []).push([[14],{

/***/ "./node_modules/babel-loader/lib/index.js?!./node_modules/vue-loader/lib/index.js?!./resources/js/Pages/Organizations/Edit.vue?vue&type=script&lang=js&":
/*!************************************************************************************************************************************************************************!*\
  !*** ./node_modules/babel-loader/lib??ref--4-0!./node_modules/vue-loader/lib??vue-loader-options!./resources/js/Pages/Organizations/Edit.vue?vue&type=script&lang=js& ***!
  \************************************************************************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _Shared_Icon__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @/Shared/Icon */ "./resources/js/Shared/Icon.vue");
/* harmony import */ var _Shared_Layout__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @/Shared/Layout */ "./resources/js/Shared/Layout.vue");
/* harmony import */ var _Shared_LoadingButton__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @/Shared/LoadingButton */ "./resources/js/Shared/LoadingButton.vue");
/* harmony import */ var _Shared_SelectInput__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @/Shared/SelectInput */ "./resources/js/Shared/SelectInput.vue");
/* harmony import */ var _Shared_TextInput__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @/Shared/TextInput */ "./resources/js/Shared/TextInput.vue");
/* harmony import */ var _Shared_TrashedMessage__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @/Shared/TrashedMessage */ "./resources/js/Shared/TrashedMessage.vue");
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
  metaInfo: function metaInfo() {
    return {
      title: this.form.name
    };
  },
  layout: _Shared_Layout__WEBPACK_IMPORTED_MODULE_1__["default"],
  components: {
    Icon: _Shared_Icon__WEBPACK_IMPORTED_MODULE_0__["default"],
    LoadingButton: _Shared_LoadingButton__WEBPACK_IMPORTED_MODULE_2__["default"],
    SelectInput: _Shared_SelectInput__WEBPACK_IMPORTED_MODULE_3__["default"],
    TextInput: _Shared_TextInput__WEBPACK_IMPORTED_MODULE_4__["default"],
    TrashedMessage: _Shared_TrashedMessage__WEBPACK_IMPORTED_MODULE_5__["default"]
  },
  props: {
    errors: Object,
    organization: Object
  },
  remember: 'form',
  data: function data() {
    return {
      sending: false,
      form: {
        name: this.organization.name,
        email: this.organization.email,
        phone: this.organization.phone,
        address: this.organization.address,
        city: this.organization.city,
        region: this.organization.region,
        country: this.organization.country,
        postal_code: this.organization.postal_code
      }
    };
  },
  methods: {
    submit: function submit() {
      var _this = this;

      this.$inertia.put('/organizations/' + this.organization.id, this.form, {
        onStart: function onStart() {
          return _this.sending = true;
        },
        onFinish: function onFinish() {
          return _this.sending = false;
        }
      });
    },
    destroy: function destroy() {
      if (confirm('Are you sure you want to delete this organization?')) {
        this.$inertia["delete"]('/organizations/' + this.organization.id);
      }
    },
    restore: function restore() {
      if (confirm('Are you sure you want to restore this organization?')) {
        this.$inertia.put('/organizations/' + this.organization.id + "/restore");
      }
    }
  }
});

/***/ }),

/***/ "./node_modules/vue-loader/lib/loaders/templateLoader.js?!./node_modules/vue-loader/lib/index.js?!./resources/js/Pages/Organizations/Edit.vue?vue&type=template&id=38f4de22&":
/*!****************************************************************************************************************************************************************************************************************!*\
  !*** ./node_modules/vue-loader/lib/loaders/templateLoader.js??vue-loader-options!./node_modules/vue-loader/lib??vue-loader-options!./resources/js/Pages/Organizations/Edit.vue?vue&type=template&id=38f4de22& ***!
  \****************************************************************************************************************************************************************************************************************/
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
  return _c(
    "div",
    [
      _c(
        "h1",
        { staticClass: "mb-8 font-bold text-3xl" },
        [
          _c(
            "inertia-link",
            {
              staticClass: "text-indigo-400 hover:text-indigo-600",
              attrs: { href: "/organizations" }
            },
            [_vm._v("Organizations")]
          ),
          _vm._v(" "),
          _c("span", { staticClass: "text-indigo-400 font-medium" }, [
            _vm._v("/")
          ]),
          _vm._v("\n    " + _vm._s(_vm.form.name) + "\n  ")
        ],
        1
      ),
      _vm._v(" "),
      _vm.organization.deleted_at
        ? _c(
            "trashed-message",
            { staticClass: "mb-6", on: { restore: _vm.restore } },
            [_vm._v("\n    This organization has been deleted.\n  ")]
          )
        : _vm._e(),
      _vm._v(" "),
      _c(
        "div",
        { staticClass: "bg-white rounded shadow overflow-hidden max-w-3xl" },
        [
          _c(
            "form",
            {
              on: {
                submit: function($event) {
                  $event.preventDefault()
                  return _vm.submit($event)
                }
              }
            },
            [
              _c(
                "div",
                { staticClass: "p-8 -mr-6 -mb-8 flex flex-wrap" },
                [
                  _c("text-input", {
                    staticClass: "pr-6 pb-8 w-full lg:w-1/2",
                    attrs: { error: _vm.errors.name, label: "Name" },
                    model: {
                      value: _vm.form.name,
                      callback: function($$v) {
                        _vm.$set(_vm.form, "name", $$v)
                      },
                      expression: "form.name"
                    }
                  }),
                  _vm._v(" "),
                  _c("text-input", {
                    staticClass: "pr-6 pb-8 w-full lg:w-1/2",
                    attrs: { error: _vm.errors.email, label: "Email" },
                    model: {
                      value: _vm.form.email,
                      callback: function($$v) {
                        _vm.$set(_vm.form, "email", $$v)
                      },
                      expression: "form.email"
                    }
                  }),
                  _vm._v(" "),
                  _c("text-input", {
                    staticClass: "pr-6 pb-8 w-full lg:w-1/2",
                    attrs: { error: _vm.errors.phone, label: "Phone" },
                    model: {
                      value: _vm.form.phone,
                      callback: function($$v) {
                        _vm.$set(_vm.form, "phone", $$v)
                      },
                      expression: "form.phone"
                    }
                  }),
                  _vm._v(" "),
                  _c("text-input", {
                    staticClass: "pr-6 pb-8 w-full lg:w-1/2",
                    attrs: { error: _vm.errors.address, label: "Address" },
                    model: {
                      value: _vm.form.address,
                      callback: function($$v) {
                        _vm.$set(_vm.form, "address", $$v)
                      },
                      expression: "form.address"
                    }
                  }),
                  _vm._v(" "),
                  _c("text-input", {
                    staticClass: "pr-6 pb-8 w-full lg:w-1/2",
                    attrs: { error: _vm.errors.city, label: "City" },
                    model: {
                      value: _vm.form.city,
                      callback: function($$v) {
                        _vm.$set(_vm.form, "city", $$v)
                      },
                      expression: "form.city"
                    }
                  }),
                  _vm._v(" "),
                  _c("text-input", {
                    staticClass: "pr-6 pb-8 w-full lg:w-1/2",
                    attrs: {
                      error: _vm.errors.region,
                      label: "Province/State"
                    },
                    model: {
                      value: _vm.form.region,
                      callback: function($$v) {
                        _vm.$set(_vm.form, "region", $$v)
                      },
                      expression: "form.region"
                    }
                  }),
                  _vm._v(" "),
                  _c(
                    "select-input",
                    {
                      staticClass: "pr-6 pb-8 w-full lg:w-1/2",
                      attrs: { error: _vm.errors.country, label: "Country" },
                      model: {
                        value: _vm.form.country,
                        callback: function($$v) {
                          _vm.$set(_vm.form, "country", $$v)
                        },
                        expression: "form.country"
                      }
                    },
                    [
                      _c("option", { domProps: { value: null } }),
                      _vm._v(" "),
                      _c("option", { attrs: { value: "CA" } }, [
                        _vm._v("Canada")
                      ]),
                      _vm._v(" "),
                      _c("option", { attrs: { value: "US" } }, [
                        _vm._v("United States")
                      ])
                    ]
                  ),
                  _vm._v(" "),
                  _c("text-input", {
                    staticClass: "pr-6 pb-8 w-full lg:w-1/2",
                    attrs: {
                      error: _vm.errors.postal_code,
                      label: "Postal code"
                    },
                    model: {
                      value: _vm.form.postal_code,
                      callback: function($$v) {
                        _vm.$set(_vm.form, "postal_code", $$v)
                      },
                      expression: "form.postal_code"
                    }
                  })
                ],
                1
              ),
              _vm._v(" "),
              _c(
                "div",
                {
                  staticClass:
                    "px-8 py-4 bg-gray-100 border-t border-gray-200 flex items-center"
                },
                [
                  !_vm.organization.deleted_at
                    ? _c(
                        "button",
                        {
                          staticClass: "text-red-600 hover:underline",
                          attrs: { tabindex: "-1", type: "button" },
                          on: { click: _vm.destroy }
                        },
                        [_vm._v("Delete Organization")]
                      )
                    : _vm._e(),
                  _vm._v(" "),
                  _c(
                    "loading-button",
                    {
                      staticClass: "btn-indigo ml-auto",
                      attrs: { loading: _vm.sending, type: "submit" }
                    },
                    [_vm._v("Update Organization")]
                  )
                ],
                1
              )
            ]
          )
        ]
      ),
      _vm._v(" "),
      _c("h2", { staticClass: "mt-12 font-bold text-2xl" }, [
        _vm._v("Contacts")
      ]),
      _vm._v(" "),
      _c(
        "div",
        { staticClass: "mt-6 bg-white rounded shadow overflow-x-auto" },
        [
          _c(
            "table",
            { staticClass: "w-full whitespace-no-wrap" },
            [
              _vm._m(0),
              _vm._v(" "),
              _vm._l(_vm.organization.contacts, function(contact) {
                return _c(
                  "tr",
                  {
                    key: contact.id,
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
                            attrs: { href: "/contacts/" + contact.id + "/edit" }
                          },
                          [
                            _vm._v(
                              "\n            " +
                                _vm._s(
                                  contact.first_name + " " + contact.last_name
                                ) +
                                "\n            "
                            ),
                            contact.deleted_at
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
                              href: "/contacts/" + contact.id + "/edit",
                              tabindex: "-1"
                            }
                          },
                          [
                            _vm._v(
                              "\n            " +
                                _vm._s(contact.city) +
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
                      { staticClass: "border-t" },
                      [
                        _c(
                          "inertia-link",
                          {
                            staticClass: "px-6 py-4 flex items-center",
                            attrs: {
                              href: "/contacts/" + contact.id + "/edit",
                              tabindex: "-1"
                            }
                          },
                          [
                            _vm._v(
                              "\n            " +
                                _vm._s(contact.phone) +
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
                              href: "/contacts/" + contact.id + "/edit",
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
              _vm.organization.contacts.length === 0
                ? _c("tr", [
                    _c(
                      "td",
                      {
                        staticClass: "border-t px-6 py-4",
                        attrs: { colspan: "4" }
                      },
                      [_vm._v("No contacts found.")]
                    )
                  ])
                : _vm._e()
            ],
            2
          )
        ]
      )
    ],
    1
  )
}
var staticRenderFns = [
  function() {
    var _vm = this
    var _h = _vm.$createElement
    var _c = _vm._self._c || _h
    return _c("tr", { staticClass: "text-left font-bold" }, [
      _c("th", { staticClass: "px-6 pt-6 pb-4" }, [_vm._v("Name")]),
      _vm._v(" "),
      _c("th", { staticClass: "px-6 pt-6 pb-4" }, [_vm._v("City")]),
      _vm._v(" "),
      _c("th", { staticClass: "px-6 pt-6 pb-4", attrs: { colspan: "2" } }, [
        _vm._v("Phone")
      ])
    ])
  }
]
render._withStripped = true



/***/ }),

/***/ "./resources/js/Pages/Organizations/Edit.vue":
/*!***************************************************!*\
  !*** ./resources/js/Pages/Organizations/Edit.vue ***!
  \***************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _Edit_vue_vue_type_template_id_38f4de22___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./Edit.vue?vue&type=template&id=38f4de22& */ "./resources/js/Pages/Organizations/Edit.vue?vue&type=template&id=38f4de22&");
/* harmony import */ var _Edit_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./Edit.vue?vue&type=script&lang=js& */ "./resources/js/Pages/Organizations/Edit.vue?vue&type=script&lang=js&");
/* empty/unused harmony star reexport *//* harmony import */ var _node_modules_vue_loader_lib_runtime_componentNormalizer_js__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../../node_modules/vue-loader/lib/runtime/componentNormalizer.js */ "./node_modules/vue-loader/lib/runtime/componentNormalizer.js");





/* normalize component */

var component = Object(_node_modules_vue_loader_lib_runtime_componentNormalizer_js__WEBPACK_IMPORTED_MODULE_2__["default"])(
  _Edit_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_1__["default"],
  _Edit_vue_vue_type_template_id_38f4de22___WEBPACK_IMPORTED_MODULE_0__["render"],
  _Edit_vue_vue_type_template_id_38f4de22___WEBPACK_IMPORTED_MODULE_0__["staticRenderFns"],
  false,
  null,
  null,
  null
  
)

/* hot reload */
if (false) { var api; }
component.options.__file = "resources/js/Pages/Organizations/Edit.vue"
/* harmony default export */ __webpack_exports__["default"] = (component.exports);

/***/ }),

/***/ "./resources/js/Pages/Organizations/Edit.vue?vue&type=script&lang=js&":
/*!****************************************************************************!*\
  !*** ./resources/js/Pages/Organizations/Edit.vue?vue&type=script&lang=js& ***!
  \****************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _node_modules_babel_loader_lib_index_js_ref_4_0_node_modules_vue_loader_lib_index_js_vue_loader_options_Edit_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! -!../../../../node_modules/babel-loader/lib??ref--4-0!../../../../node_modules/vue-loader/lib??vue-loader-options!./Edit.vue?vue&type=script&lang=js& */ "./node_modules/babel-loader/lib/index.js?!./node_modules/vue-loader/lib/index.js?!./resources/js/Pages/Organizations/Edit.vue?vue&type=script&lang=js&");
/* empty/unused harmony star reexport */ /* harmony default export */ __webpack_exports__["default"] = (_node_modules_babel_loader_lib_index_js_ref_4_0_node_modules_vue_loader_lib_index_js_vue_loader_options_Edit_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0__["default"]); 

/***/ }),

/***/ "./resources/js/Pages/Organizations/Edit.vue?vue&type=template&id=38f4de22&":
/*!**********************************************************************************!*\
  !*** ./resources/js/Pages/Organizations/Edit.vue?vue&type=template&id=38f4de22& ***!
  \**********************************************************************************/
/*! exports provided: render, staticRenderFns */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _node_modules_vue_loader_lib_loaders_templateLoader_js_vue_loader_options_node_modules_vue_loader_lib_index_js_vue_loader_options_Edit_vue_vue_type_template_id_38f4de22___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! -!../../../../node_modules/vue-loader/lib/loaders/templateLoader.js??vue-loader-options!../../../../node_modules/vue-loader/lib??vue-loader-options!./Edit.vue?vue&type=template&id=38f4de22& */ "./node_modules/vue-loader/lib/loaders/templateLoader.js?!./node_modules/vue-loader/lib/index.js?!./resources/js/Pages/Organizations/Edit.vue?vue&type=template&id=38f4de22&");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "render", function() { return _node_modules_vue_loader_lib_loaders_templateLoader_js_vue_loader_options_node_modules_vue_loader_lib_index_js_vue_loader_options_Edit_vue_vue_type_template_id_38f4de22___WEBPACK_IMPORTED_MODULE_0__["render"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "staticRenderFns", function() { return _node_modules_vue_loader_lib_loaders_templateLoader_js_vue_loader_options_node_modules_vue_loader_lib_index_js_vue_loader_options_Edit_vue_vue_type_template_id_38f4de22___WEBPACK_IMPORTED_MODULE_0__["staticRenderFns"]; });



/***/ })

}]);