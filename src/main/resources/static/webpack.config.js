const path = require('path');

module.exports = {
	 output: { chunkFilename: 'public/js/[name].js?id=[chunkhash]' },
    resolve: {
        alias: {
            vue$: 'vue/dist/vue.runtime.esm.js',
            '@': path.resolve('resources/js'),
        },
    },
};
