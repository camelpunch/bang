(ns com.camelpunch.bang.system
  (:require [lanterna.terminal :as t]
            [com.camelpunch.bang.screen :as scr]
            [com.camelpunch.bang.core]
            [com.stuartsierra.component :as component])
  (:import [com.camelpunch.bang.screen Screen]
           [com.camelpunch.bang.core Game]))

(defn system []
  (component/system-map
   :screen (Screen.)
   :game (component/using (Game.) [:screen])))
