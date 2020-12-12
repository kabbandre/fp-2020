(ns ld-4.main
  (:use [clojure.test]))

(defn replace-spaces [string]
  (clojure.string/replace string #" " "_"))

(defn replace-underscores [string]
  (clojure.string/replace string #"_" " "))

(defn validate-string [string]
  (re-matches #"^[a-zA-Z\_]+$" string))

(defn e [string rails]
  (->> string
       (map (partial vector) rails)
       (sort-by first)
       (map second)))

(defn encrypt-handler [string key]
  (e string (cycle (concat (range 1 (+ key 1)) (range (- key 1) 1 -1)))))

(defn encrypt-init [string key]
  (if (nil? (validate-string (replace-spaces string)))
    nil
    (apply str (encrypt-handler (replace-spaces string) key)))
  )

(defn decrypt-handler [string key]
  (e string (encrypt-handler (range (count string)) key)))

(defn decrypt-init [string key]
  (if (nil? (validate-string (replace-spaces string)))
    nil
    (apply str (decrypt-handler (replace-underscores string) key))))


(def lorem-ipsum "Lorem ipsum dolor sit amet  consectetur adipiscing elit  Curabitur dignissim felis ut tortor efficitur  ac congue urna aliquam  Vestibulum ac felis eros  Curabitur gravida tempor lorem pellentesque suscipit  Quisque ullamcorper accumsan tellus  et volutpat tortor aliquam quis  In aliquam ex quis mauris pellentesque  vel aliquet felis blandit  Nulla ullamcorper dui sem  tempus suscipit metus sagittis et  Pellentesque eu urna eu sem lacinia iaculis at eu eros  Sed nec rutrum nisl  Aenean lacinia metus lectus  a ultrices dui rhoncus id  Mauris ut faucibus odio")
(def encoded-lorem-ipsum-21-rails "Lailtsl_leiiscdo_dlsaiiuuclunae_prtsnailieoirrie__qbrsiesIlvar_t_i_n_rs_oeupfuaua__pt__i_lodieci__t_smti_tnargei___q_icugtaamAldu_esm_rmurutnesueqmia_lcueuubitcitu_Caq_atiauua_s__urn_iipciso___vs_s_umqels_Pmltea_csensreV_ieQmvq_stleseeiua_ruusgituesdtuuo_ee_umulssrn_hamn_nogsoaniclmxtf__tl____sof_oegrntr_escua_nea_eeuaclun_dcli_oietlqatuqelltmneteatcto_idecb_elu_pqulile_t__nccuul_t_f_usmeeraiilsumteae_ies_ot_rfclipp_etlse_Npisnudnl_sre_uiaulo_up_a_pb_upqr_ei_ii_mCtc_mermlrt_m_l_siuueSasdrsauii__f_eloorasat_ce_r__u_ui_rbtra_lracrouiniss_uo_mt_ataucomtrdueseM")

(testing "Encrypt"
  (is (= (encrypt-init "hello world" 3) "horel_ollwd"))
  (is (= (encrypt-init "Mihails Jeremejevs" 9) "Mvieshjaeimlesr_eJ"))
  (is (= (encrypt-init lorem-ipsum 21) encoded-lorem-ipsum-21-rails)))

(testing "Decrypt"
  (is (= (decrypt-init "horel_ollwd" 3) "hello world"))
  (is (= (decrypt-init "Mvieshjaeimlesr_eJ" 9) "Mihails Jeremejevs"))
  (is (= (decrypt-init encoded-lorem-ipsum-21-rails 21) lorem-ipsum)))

(testing "Invalid strings"
  (is (= (encrypt-init "hello!!!:" 3) nil))
  (is (= (decrypt-init "hola!!!:" 3) nil)))




