(ns com.camelpunch.bang.system
  (:require [lanterna.terminal :as t]
            [com.camelpunch.bang.screen :as scr]
            [com.stuartsierra.component :as component])
  (:import [com.camelpunch.bang.screen Screen]))

(defn system []
  (component/system-map
   :screen (Screen.)))
