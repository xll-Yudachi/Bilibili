const webpack = require('webpack')
module.exports = {
  plugins: [
    {
      src: '~plugins/ElementUI',
      ssr: true,
    }
  ],
  css: [
    'element-ui/lib/theme-chalk/index.css'
  ],
  /*
  ** Headers of the page
  */
  head: {
    title: 'bilibili-nuxt',
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'description', name: 'description', content: '视频详情页展示' }
    ],
    link: [
      { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' }
    ]
  },
  /*
  ** Customize the progress bar color
  */
  loading: { color: '#3B8070' },
  /*
  ** Build configuration
  */
  build: {
    /*
    ** Run ESLint on save
    */
    extend (config, { isDev, isClient }) {
      if (isDev && isClient) {
        config.module.rules.push({
          enforce: 'pre',
          test: /\.(js|vue)$/,
          loader: 'eslint-loader',
          exclude: /(node_modules)/
        })
      }
    },
    plugins: [
      new webpack.ProvidePlugin({
        '$': 'jquery',
        jQuery: 'jquery',
        'window.jQuery': 'jquery',
      }),

    ],
    vendor:['element-ui']
  }
}
